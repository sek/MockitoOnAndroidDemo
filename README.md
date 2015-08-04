This very simple project demonstrates running Mockito on Android (gradle build system)

It also demonstrates an issue from the dexmaker project: https://github.com/crittercism/dexmaker/issues/12

To clone and run tests:

    git clone https://github.com/sek/MockitoOnAndroidDemo
    cd MockitoOnAndroidDemo
    ./gradlew connectedAndroidTest --stacktrace

It should also open smoothly in Android Studio 1.3 for editing.

The version of dexmaker can be modified on line 27 of app/build.grade
