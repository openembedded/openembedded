DEPENDS += "vala-native"

FILES_${PN}-dev += "\
  ${datadir}/vala/vapi/*.vapi \
  ${datadir}/vala/vapi/*.deps \
"

VALA_DONT_STAGE_VAPIS ?= "\(/config.vapi$\)\|\(/config.deps$\)"

# .vapi and .deps files are arch independent and need to be present in the
# staging datadir for the native vala compiler
do_stage_append() {
	install -d ${STAGING_DATADIR_NATIVE}/vala/vapi
	for VALAFILE in `find . -name "*.vapi" | grep -v "$VALA_DONT_STAGE_VAPIS"`; do install -m 0644 ${VALAFILE} ${STAGING_DATADIR_NATIVE}/vala/vapi/; done
	for VALAFILE in `find . -name "*.deps" | grep -v "$VALA_DONT_STAGE_VAPIS"`; do install -m 0644 ${VALAFILE} ${STAGING_DATADIR_NATIVE}/vala/vapi/; done
}
