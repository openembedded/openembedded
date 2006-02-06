include esmart.inc
PR = "r2"

SRC_URI += "file://include-stdio.patch;patch=1"

myheaders = "esmart_container/Esmart_Container.h \
             esmart_draggies/Esmart_Draggies.h \
             esmart_file_dialog/Esmart_File_Dialog.h \
             esmart_text_entry/Esmart_Text_Entry.h \
             esmart_thumb/Esmart_Thumb.h \
             esmart_trans_x11/Esmart_Trans_X11.h"
#             esmart_textarea/Esmart_Textarea.h \

mylibraries = "esmart_container \
               esmart_draggies \
               esmart_file_dialog \
               esmart_text_entry \
               esmart_thumb \
               esmart_trans_x11"
#               esmart_textarea \

do_compile_prepend() {
	find ${S} -type f -name "*.[ch]" | xargs sed -i 's:NULL:0:g'
}