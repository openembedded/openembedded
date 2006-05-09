include sylpheed-claws-extra-plugins.inc

DEPENDS_append = " libxml2 curl glib-2.0 gtk+"

S = ${WORKDIR}/sylpheed-claws-extra-plugins-${PV}/rssyl-0.4cvs8

FILES_${PN} = "${libdir}/sylpheed-claws/plugins/rssyl.so"

