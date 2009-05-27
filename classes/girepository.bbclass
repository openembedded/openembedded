#Keep the *.gir files at runtime until *.typelib are used
FILES_${PN} += "${datadir}/gir-1.0/*.gir"
#FILES_${PN}-dev += "${datadir}/gir-1.0/*.gir"
FILES_${PN} += "${libdir}/girepository-1.0/*.typelib"

