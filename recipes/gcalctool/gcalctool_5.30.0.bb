LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "gtk+"
DESCRIPTION = "gcalctool is a powerful calculator"

inherit gnome

SRC_URI[archive.md5sum] = "edfc788c8d107d57e84d2c3415c6442b"
SRC_URI[archive.sha256sum] = "d196a83646ae42d688bb56662d78b2ac52d9fa671ed582c516280ca0a3bc2faa"

do_configure_prepend() {
	sed -i 's:-I$(includedir)::g' src/Makefile.am
}

