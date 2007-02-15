SECTION = "openmoko/panel-plugin"
DEPENDS += "matchbox-panel-2"

inherit openmoko

FILES_${PN} = "${libdir}/matchbox-panel/lib*.so* ${datadir}"
