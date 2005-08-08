DESCRIPTION = "ESmart is a collection of smart Evas objects"
SECTION = "e/libs"
LICENSE = "MIT"
DEPENDS = "eet evas-x11 ecore-x11 epsilon embryo imlib2 jpeg libtool"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

SRC_URI = "http://enlightenment.freedesktop.org/files/esmart-${PV}.tar.gz \
           file://compile-fix.patch;patch=1"
S = "${WORKDIR}/esmart-${PV}"

inherit autotools pkgconfig binconfig

headers = "esmart_container/Esmart_Container.h \
           esmart_draggies/Esmart_Draggies.h \
           esmart_file_dialog/Esmart_File_Dialog.h \
           esmart_textarea/Esmart_Textarea.h \
           esmart_thumb/Esmart_Thumb.h \
           esmart_trans_x11/Esmart_Trans_X11.h"

do_stage() {
    for i in ${headers}; do
        install -m 0644 ${S}/src/lib/$i ${STAGING_INCDIR}/
    done
    oe_libinstall -C src/lib libsmart ${STAGING_LIBDIR}/
}

PACKAGES = "esmart-dev esmart-doc esmart"
FILES_${PN}-dev += "${bindir}/esmart-config ${bindir}/esmart"
