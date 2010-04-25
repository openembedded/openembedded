# Vala has problems with multiple concurrent invocations
PARALLEL_MAKE = ""

DEPENDS += "vala-native"

FILES_${PN}-dev += "\
  ${datadir}/vala/vapi/*.vapi \
  ${datadir}/vala/vapi/*.deps \
  ${datadir}/gir-1.0 \
"

VALA_DONT_STAGE_VAPIS ?= "\(/config.vapi$\)\|\(/config.deps$\)"

# .vapi and .deps files are arch independent and need to be present in the
# staging datadir for the native vala compiler
vala_do_stage_vapi() {
	install -d ${STAGING_DATADIR_NATIVE}/vala/vapi
	for VALAFILE in `find . -name "*.vapi" | grep -v "$VALA_DONT_STAGE_VAPIS"`; do install -m 0644 ${VALAFILE} ${STAGING_DATADIR_NATIVE}/vala/vapi/; done
	for VALAFILE in `find . -name "*.deps" | grep -v "$VALA_DONT_STAGE_VAPIS"`; do install -m 0644 ${VALAFILE} ${STAGING_DATADIR_NATIVE}/vala/vapi/; done
}

EXPORT_FUNCTIONS do_stage_vapi

addtask stage_vapi after do_populate_staging before do_package
