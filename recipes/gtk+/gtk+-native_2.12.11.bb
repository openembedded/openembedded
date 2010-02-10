
require gtk+_2.12.11.bb

inherit native

DEPENDS += "atk-native pango-native cairo-native libx11-native libxext-native libxrender-native"
PROVIDES = "gtk+-native"

EXTRA_OECONF += "--without-libtiff --disable-modules --disable-cups"

PR = "r3"

do_install_append() {

    # this tool is required by gnome-keyring 2.26.0 to get built
    # it is written in Python and use only Python xml
    install -d ${STAGING_BINDIR_NATIVE}
    install -m 0755 ${S}/gtk/gtk-builder-convert ${STAGING_BINDIR_NATIVE}
}

