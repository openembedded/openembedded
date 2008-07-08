# Toolchain for neuros-osd devices

PR = "r1"

TOOLCHAIN_HOST_TASK = "task-sdk-host"

require meta-toolchain.bb

TOOLCHAIN_TARGET_TASK += " \
                          dbus dbus-dev \
                          qt-embedded qt-embedded-dev \ 
                         "

SDK_SUFFIX = "toolchain-neuros"
