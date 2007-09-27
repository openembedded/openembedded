require mono_1.2.5.inc
PR = "r0"
DEPENDS = "glib-2.0-native"

inherit native

#do_stage_prepend() {
#	install -m 755 ${S}/mono/monoburg/monoburg ${STAGING_BINDIR}
#}

