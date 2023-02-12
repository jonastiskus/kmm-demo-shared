# kmm-demo-shared
Kotlin multiplatform shared code for iOS and Android which shares data, domain and presentation modules.

This shared code example fetches https://cat-fact.herokuapp.com/facts endpoint for list of facts about cats and exposes a state required for consumer to display data.

# Cat facts screen state
```kotlin
data class FactsUiState(
    val isLoading: Boolean = false,
    val facts: List<Fact> = emptyList(),
    val error: Throwable? = null
)
```

Consumers needs to initialize `Shared` module in application entry point by setting current runtime environment like so:

# Android example:
```kotlin 
if (BuildConfig.DEBUG) {
    Shared.init(Environment.DEV)
} else {
    Shared.init(Environment.PRODUCTION)
}
```

# iOS example:
```swift
#ifdef DEBUG
    Shared.shared.doInit(environment: Environment.dev)
#else
    Shared.shared.doInit(environment: Environment.production)
#endif
```

Note: DEV and PRODUCTION environments uses the same endpoint for fetching facts about cats. It's only for demonstration purpose.

Next, we can start consuming data states in exposed ViewModel classes.

[Android example](https://github.com/jonastiskus/kmm-demo-android/blob/master/app/src/main/java/com/jonas/tiskus/kmm/demo/android/MainActivity.kt)

[iOS example](https://github.com/jonastiskus/kmm-demo-ios/blob/master/kmm-demo-ios/FactsViewController.swift)

Note: In iOS we want to `clear()` our ViewModel to cancel still going coroutines or tasks in ViewModel scope. Android deals with it automatically in its lifecycle.
