# This is a straw-man recipe for step 1 in the two-step build of
# mono. Because it's impossible to build the mcs directory
# in cross-compile mode, this recipe will do a native build,
# then tar the resulting install tree for usage by the mono
# package in step 2.
# See http://www.mono-project.com/Mono:ARM

require mono_2.2.0.inc
require mono-mcs-intermediate.inc

DEFAULT_PREFERENCE = "-1"

#SRC_URI += "file://libgc_cppflags.patch;patch=1"



SRC_URI[md5sum] = "6dfc8364f6e761d558f134a707bae421"
SRC_URI[sha256sum] = "44fc0eddf56c0abe861190051fceec6e223122c5835967459c69fbf98ee52067"
