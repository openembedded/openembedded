DESCRIPTION = "Tasks for xqtlauncher stuff"
SECTION = "opie/base"
LICENSE = "MIT"
PR = "r0"

inherit task

PACKAGES = "task-xqtlauncher task-xqtlauncher-blackbox"

#xkbd is currently needed becuse of a bug at xqt2
RDEPENDS_task-xqtlauncher = "xqtlauncher \
                             xqtlauncher-xkbd-desktop \
                            "

#
# xqtlauncher with blackbox as wm
#

RDEPENDS_task-xqtlauncher-blackbox = "xqtlauncher-blackbox-config \
                                     "

