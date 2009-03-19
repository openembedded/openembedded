require zope_${PV}.bb
inherit native

DEPENDS = "python-native"

inherit distutils-base

export BUILD_SYS
export HOST_SYS

