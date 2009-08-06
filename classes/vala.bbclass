DEPENDS += "vala-native"

FILES_${PN}-dev += "\
  ${datadir}/vala/vapi/*.vapi \
  ${datadir}/vala/vapi/*.deps \
"

# .vapi and .deps files are arch independent and need to be present in the
# staging datadir for the native vala compiler
do_stage_append() {
	install -d ${STAGING_DATADIR_NATIVE}/vala/vapi
	find . -name "*.vapi" -exec install -m 0644 {} ${STAGING_DATADIR_NATIVE}/vala/vapi/ \;
	find . -name "*.deps" -exec install -m 0644 {} ${STAGING_DATADIR_NATIVE}/vala/vapi/ \;
}
