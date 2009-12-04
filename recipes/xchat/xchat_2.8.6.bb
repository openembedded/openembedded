DESCRIPTION = "Full-featured IRC chat client with scripting support"
LICENSE = "GPL"
HOMEPAGE = "http://www.xchat.org"
SECTION = "x11/network"
DEPENDS = "libgcrypt zlib gtk+"
DEPENDS += "gdk-pixbuf-csource-native"
PR = "r1"

SRC_URI = "http://www.xchat.org/files/source/2.8/xchat-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "\
  --disable-perl \
  --disable-python \
  --disable-tcl \
"

#Fix little bug that slipped into the 2.8.6 release, already fixed upstream.
do_compile_prepend() {
        sed -i 's/GtkType/GType/' ${s}src/fe-gtk/xtext.{c,h}
}

FILES_${PN} += "${datadir}/dbus-1"
                
FILES_${PN}-dbg += "${libdir}/xchat/plugins/.debug"
