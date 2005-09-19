DESCRIPTION = "ESmart is a collection of smart Evas objects"
LICENSE = "MIT"
DEPENDS = "virtual/evas virtual/ecore virtual/imlib2 epsilon edje libtool"
PROVIDES += "virtual/esmart"

inherit efl

SRC_URI = "http://enlightenment.freedesktop.org/files/esmart-${PV}.tar.gz \
           file://compile-fix.patch;patch=1"
S = "${WORKDIR}/esmart-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/esmart"

headers = ""
libraries = ""

myheaders = "<override me>"
mylibraries = "<override me>"

do_stage_append() {
	install -d ${STAGING_INCDIR}/Esmart/
	for i in ${myheaders}; do
		install -m 0644 ${S}/src/lib/$i ${STAGING_INCDIR}/Esmart/
	done
	oe_libinstall -C src/lib libsmart ${STAGING_LIBDIR}/
	for i in ${mylibraries}; do
		oe_libinstall -C src/lib/$i lib$i ${STAGING_LIBDIR}/
	done
}

PACKAGES =+ "libesmart-textentry \
             libesmart-thumb \
             libesmart-container \
             libesmart-container-plugins \
             libesmart-file-dialog \
             libesmart-draggies \
             libesmart-trans-x11"
FILES_libesmart-textentry = "${libdir}/libesmart_text_entry*.so*"
FILES_libesmart-thumb = "${libdir}/libesmart_thumb*.so*"
FILES_libesmart-container = "${libdir}/libesmart_container*"
DEPENDS_libesmart-container += "libesmart-container-plugins"
FILES_libesmart-container-plugins = "${libdir}/esmart/layout/*.so"
FILES_libesmart-file-dialog = "${libdir}/libesmart_file_dialog*.so*"
FILES_libesmart-draggies = "${libdir}/libesmart_draggies*.so*"
FILES_libesmart-trans-x11 = "${libdir}/libesmart_trans_x11*.so*"
