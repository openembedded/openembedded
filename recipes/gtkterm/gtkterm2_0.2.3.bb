DESCRIPTION = "A lightweight terminal emulator based on VTE and Gtk+"
HOMEPAGE = "http://gtkterm.feige.net/"
AUTHOR = "Oliver Feige"
SECTION = "x11/terminals"
DEPENDS = "gtk+ vte"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtkterm/gtkterm2-${PV}.tar.gz"

inherit autotools


SRC_URI[md5sum] = "a49f93d15909dbd2e7011428ae01f0f0"
SRC_URI[sha256sum] = "fb68b18d752ae2379f144186b94743be991af1a42c88bc1e6f0685e45cb1d573"
