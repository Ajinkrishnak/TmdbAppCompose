package com.example.tmdbapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tmdbapp.data.ApiService
import com.example.tmdbapp.data.model.movies.MovieItem
import com.example.tmdbapp.utils.Constants.NETWORK_PAGE_SIZE
import com.example.tmdbapp.utils.Constants.STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class UpcomingPagingSource(private val apiService: ApiService, private val lang:String) : PagingSource<Int, MovieItem>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val data = apiService.getUpcoming(
                page = position,
                language = lang
            )
            val nextKey = if (data.results?.isEmpty() == true) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            val prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1
            LoadResult.Page(
                data = data.results!!,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieItem>): Int? {
        return state.anchorPosition
    }
}