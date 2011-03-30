require matrix-gui-common.inc

# Use the mem_util application from am-sysinfo instead of a
# prebuilt version in the repository.
RRECOMMENDS_${PN} = "am-sysinfo"

SRCREV = "243"
PR = "${INC_PR}.8"
