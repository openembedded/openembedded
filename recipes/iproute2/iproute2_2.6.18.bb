PR = "${INC_PR}.0"

require iproute2.inc

SRC_URI += "file://iproute2-2.6.15_no_strip.diff;patch=1;pnum=0 \
            file://new-flex-fix.patch;patch=1"

DATE = "061002"

SRC_URI[md5sum] = "193b570128cf852afba337438413adf9"
SRC_URI[sha256sum] = "038aabd2894f46d3a4a7583ab2bff13b2da51682ccb921ceb7c87326ec1d344f"
