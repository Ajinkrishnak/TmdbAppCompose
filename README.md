# TmdbAppCompose
An android app built using Jetpack Compose that consumes TMDB API to display the current popular, now playing, upcoming, and top rated movies. It also shows the details and trailer..

## Prerequisites
Add your [TMDB](https://www.themoviedb.org/) API key in the `local.properties` file:
```
TMDB_API_KEY="YOUR_API_KEY"
```
## Screenshots
<img src="https://user-images.githubusercontent.com/48273411/210358426-4d34cf3e-67ba-4bcd-b13e-26b353e26ea4.png" width="250" /> <img src="https://user-images.githubusercontent.com/48273411/210358652-aaf94cfc-9c6d-43de-bf54-be6c2bc05661.png" width="250" /> <img src="https://user-images.githubusercontent.com/48273411/210358837-288db934-7dce-478a-b16d-1677ccc109e0.png" width="250" />

## Tech Stack 🛠
- [Jetpack Compose](https://developer.android.com/jetpack/compose/) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
- [Kotlin](https://kotlinlang.org/) - Officially supported programming language for Android development.
- [MVVM Architecture](https://developer.android.com/topic/architecture) - A software architecture that removes the tight coupling between components. Most importantly, in this architecture, the children don't have the direct reference to the parent, they only have the reference by observables.
- [Hilt](https://dagger.dev/hilt/) - Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
- [Flows](https://developer.android.com/kotlin/flow) - Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
- [Navigation](https://developer.android.com/jetpack/compose/navigation) - For naviation between composables.
- [Hilt](https://dagger.dev/hilt/) - Dependency Injection Framework
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse.
- [Retrofit](https://github.com/square/retrofit) - A type-safe HTTP client for Android and Java.
- [OkHttp Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Logs HTTP request and response data.
- [Lottie Files for Compose](https://github.com/airbnb/lottie) - Lottie is a library for Android, iOS, and Web that parses [Adobe After Effects](http://www.adobe.com/products/aftereffects.html) animations exported as json with [Bodymovin](https://github.com/airbnb/lottie-web) and renders them natively on mobile and on the web!
- [Compose Pagination](https://developer.android.com/jetpack/androidx/releases/paging) - The Paging Library makes it easier for you to load data gradually and gracefully within your app.

## How to install?

You can install this application to test on your android smartphone. To download the signed application go to your chrome browser and copy-paste the download link:

```
https://github.com/Ajinkrishnak/TmdbAppCompose/releases/download/v0.1.0-alpha/tmdb-app.apk
```

Download will be started automatically. After then install it on your android device.

N.B: It supports only in android version 5.0 or later.

SDK levels supported
--------------------
- Minimum SDK 21
- Target SDK 33
