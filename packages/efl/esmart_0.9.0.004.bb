DESCRIPTION = "ESmart is a collection of smart Evas objects"
LICENSE = "MIT"
DEPENDS = "evas-x11 ecore-x11 virtual/imlib2 epsilon edje libtool"
PR = "r1"

inherit efl

SRC_URI += "file://compile-fix.patch;patch=1"

headers = ""
libraries = ""

myheaders = "esmart_container/Esmart_Container.h \
             esmart_draggies/Esmart_Draggies.h \
             esmart_file_dialog/Esmart_File_Dialog.h \
             esmart_text_entry/Esmart_Text_Entry.h \
             esmart_textarea/Esmart_Textarea.h \
             esmart_thumb/Esmart_Thumb.h \
             esmart_trans_x11/Esmart_Trans_X11.h"

mylibraries = "esmart_container \
               esmart_draggies \
               esmart_file_dialog \
               esmart_text_entry \
               esmart_textarea \
               esmart_thumb \
               esmart_trans_x11"

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
