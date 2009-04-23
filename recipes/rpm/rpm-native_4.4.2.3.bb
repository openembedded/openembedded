inherit native distutils-native-base

require rpm-${PV}.inc

DEPENDS = "beecrypt-native gettext-native zlib-native file-native popt-native python-native"
PACKAGES = ""

export localstatedir = "${layout_localstatedir}"
export varprefix = "${layout_localstatedir}"
