include esmart.inc
PR = "r0"

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/esmart;date=${PV}"
S = "${WORKDIR}/esmart"

SRC_URI += "file://disable-x-only-features.patch;patch=1"

myheaders = "esmart_container/Esmart_Container.h \
             esmart_draggies/Esmart_Draggies.h \
             esmart_file_dialog/Esmart_File_Dialog.h \
             esmart_text_entry/Esmart_Text_Entry.h \
             esmart_textarea/Esmart_Textarea.h \
             esmart_thumb/Esmart_Thumb.h"

mylibraries = "esmart_container \
               esmart_draggies \
               esmart_file_dialog \
               esmart_text_entry \
               esmart_textarea \
               esmart_thumb"
