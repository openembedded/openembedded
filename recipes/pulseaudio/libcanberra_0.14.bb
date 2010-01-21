DESCRIPTION = "Libcanberra is an implementation of the XDG Sound Theme and Name \
Specifications, for generating event sounds on free desktops."
LICENSE = "LGPL"
DEPENDS = "alsa-lib gstreamer gtk+ libvorbis pulseaudio"
SECTION = "libs/multimedia"
AUTHOR = "Lennart Poettering"
HOMEPAGE = "http://0pointer.de/lennart/projects/libcanberra"
PR = "r2"

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

SRC_URI = "http://0pointer.de/lennart/projects/libcanberra/libcanberra-${PV}.tar.gz \
           file://libcanberra-increase-buffer-size.patch;patch=1"

EXTRA_OECONF = "\
  --enable-alsa \
  --enable-gstreamer \
  --enable-gtk \
  --enable-multi \
  --enable-null \
  --disable-oss \
# enable pulse again when pulseaudio >= 0.9.11 is the default in OE
  --disable-pulse \
  --disable-tdb \
"

# This needs autoconf 2.62, which isn't used by any distro in OE atm
do_configure() {
	gnu-configize --force
	oe_runconf
}

# TODO: Test more fine granular version
#OE_LT_RPATH_ALLOW=":${libdir}/${P}:"
OE_LT_RPATH_ALLOW = "any"
OE_LT_RPATH_ALLOW[export] = "1"

python populate_packages_prepend() {
	plugindir = bb.data.expand('${libdir}/${P}/', d)
	do_split_packages(d, plugindir, '^libcanberra-(.*)\.so$', 'libcanberra-%s', '%s support library', extra_depends='' )
}

PACKAGES =+ "${PN}-gtk"

PACKAGES_DYNAMIC = "libcanberra-*"

FILES_${PN}-gtk = "\
  ${sysconfdir}/gconf \
  ${bindir}/* \
  ${libdir}/libcanberra-gtk.so.* \
  ${libdir}/gtk-2.0/modules/* \
  ${datadir}/gnome \
"
FILES_${PN}-dev += "\
  ${libdir}/${P}/*.la \
"
FILES_${PN}-dbg += "\
  ${libdir}/gtk-2.0/modules/.debug \
  ${libdir}/${P}/.debug \
"
