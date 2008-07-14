# Toolchain for neuros-osd devices

PR = "r2"

TOOLCHAIN_HOST_TASK = "task-sdk-host \
                       qmake2-sdk "

require meta-toolchain.bb

TOOLCHAIN_TARGET_TASK += " \
                          dbus dbus-dev \
                          qt-embedded qt-embedded-dev \ 
                         "

SDK_SUFFIX = "toolchain-neuros"
