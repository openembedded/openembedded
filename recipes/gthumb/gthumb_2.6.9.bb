DESCRIPTION = "gThumb is an image viewer and browser for the GNOME Desktop."
LICENSE = "GPL"
DEPENDS = "gtk+ libexif libgnome libgnomeui libgnomeprintui"
PR = "r1"
SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/gnome* ${datadir}/application-registry/*"

do_configure_prepend() {
	# replace paths to STAGING_BINDIR_NATIVE/perl with ${bindir}/perl
	sed -i -e "1s:#!.*:#! /usr/bin/env perl:" ${S}/intltool*.in
}

SRC_URI[md5sum] = "2819ec911a7cc4f46b95240b65f2b3e2"
SRC_URI[sha256sum] = "b02423f0dc9f82a3e1a56cfd470c1cee5d351654fdc55c1a3cd5cff150828b3c"
