require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "8b298cc3424597f8138c7faf7763dce9"
SRC_URI[archive.sha256sum] = "b3fe971ccc8152db6c78da7117c31fc4cd2fcb2b6a4df3db0f8fed13d4ceb08f"

BBCLASSEXTEND = "native"

CONFLICTS = "fixesext"
