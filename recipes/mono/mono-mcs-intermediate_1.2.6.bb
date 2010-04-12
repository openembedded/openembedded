# This is a straw-man recipe for step 1 in the two-step build of
# mono. Because it's impossible to build the mcs directory
# in cross-compile mode, this recipe will do a native build,
# then tar the resulting install tree for usage by the mono
# package in step 2.
# See http://www.mono-project.com/Mono:ARM

require mono_1.2.6.inc
require mono-mcs-intermediate.inc

PARALLEL_MAKE = ""



SRC_URI[md5sum] = "391f85b4f962269e044ceac2b5235310"
SRC_URI[sha256sum] = "24cc4f396cac3053c7ba3fe68bc1b80359d75dc4f54a85f39a73cabc3d3f560f"
