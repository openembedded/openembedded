LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon filemanager library"

DEPENDS = "hildon-thumbnail mce-dev libhildonmime osso-gwconnect hildon-libs osso-thumbnail"

PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/sardine/main/source/libh/libhildonfm/libhildonfm_${PV}.tar.gz \
           file://hildonfm-ifdef-maemogtk.diff;patch=1 \
	   "

inherit autotools pkgconfig lib_package

S = "${WORKDIR}/1_${PV}"

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
        touch gtk-doc.make
}


PARALLEL_MAKE = ""

do_stage() {
        autotools_stage_all
	ln -sf ${STAGING_INCDIR}/hildon-fm-2/hildon/* ${STAGING_INCDIR}/hildon-widgets/
}


