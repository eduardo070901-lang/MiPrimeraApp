# Implementation Plan - Suppress Layout Fidelity Warning

The previous attempt to lower the SDK version to 35 was partially successful, but the user is still reporting the "Layout fidelity warning". This plan aims to further align the SDK version with the rendering engine's limits and use explicit suppression to remove the warning from the IDE's view.

## Proposed Changes

### Build Configuration

#### [MODIFY] [app/build.gradle.kts](file:///C:/Users/pc/AndroidStudioProjects/MiPrimeraApp/app/build.gradle.kts)
- Set `compileSdk` to 36.
- Set `targetSdk` to 36.
- API 36 is the maximum supported by the current rendering engine according to the error message.

### Layout Resources

#### [MODIFY] [activity_main.xml](file:///C:/Users/pc/AndroidStudioProjects/MiPrimeraApp/app/src/main/res/layout/activity_main.xml)
- Re-add `tools:ignore="LayoutFidelity"` to the root `LinearLayout` to explicitly suppress the warning in the Layout Editor.

## Verification Plan

### Automated Tests
- Run `gradle_sync` to ensure the project builds with API 36.

### Manual Verification
- Verify that the "Layout fidelity warning" is no longer visible in the Layout Editor for `activity_main.xml`.
