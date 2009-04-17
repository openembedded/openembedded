# Toolchain for neuros-osd devices

PR = "r5"

TOOLCHAIN_HOST_TASK = "task-sdk-host \
                       qmake2-sdk uicmoc4-sdk"

require meta-toolchain.bb

TOOLCHAIN_TARGET_TASK += " \
                          dbus dbus-dev \
                          qt4-embedded qt4-embedded-dev \ 
                         "

SDK_SUFFIX = "toolchain-neuros"
