require python-pygobject_${PV}.bb

DEPENDS = "python-native glib-2.0-native"

inherit native

do_stage_append() {
	install -d ${STAGING_BINDIR}
	install -m 0755 gobject/generate-constants ${STAGING_BINDIR}/gobject-generate-constants
}
