DESCRIPTION = "Enlightened Sound Daemon"
SECTION = "gpe/base"
LICENSE = "GPL"
DEPENDS = "audiofile"
PE = "1"
PR = "r3"

inherit gnome binconfig

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/esound/0.2/esound-0.2.36.tar.bz2 \
	   https://launchpad.net/ubuntu/breezy/+source/esound/0.2.36-1ubuntu5/+files/esound_0.2.36-1ubuntu5.diff.gz;patch=1 \
           file://no-docs.patch;patch=1 \
	   file://configure-fix.patch;patch=1"

EXTRA_OECONF = " \
    --disable-alsa \
    --disable-arts \
    --disable-artstest \
"
do_configure_prepend() {
	sed -i -e 's:/usr/include/mme:${STAGING_INCDIR}/mme:g' configure.ac
}

do_stage() {
	autotools_stage_all
}	


PACKAGES =+ "esddsp esd esd-utils"

FILES_esddsp = "${bindir}/esddsp ${libdir}/libesddsp.so.*"
FILES_esd = "${bindir}/esd"
FILES_esd-utils = "${bindir}/*"

