# This is a straw-man recipe for step 1 in the two-step build of
# mono. Because it's impossible to build the mcs directory
# in cross-compile mode, this recipe will do a native build,
# then tar the resulting install tree for usage by the mono
# package in step 2.
# See http://www.mono-project.com/Mono:ARM

require mono_1.2.5.inc
require mono-mcs-intermediate.inc

PARALLEL_MAKE = ""


SRC_URI[md5sum] = "dfede0c8c29384a8f8a6953a9bd06224"
SRC_URI[sha256sum] = "434f91032e48c03e1202ba3cef1648e2708eeefcf51143d3547e34acc9c68a96"
