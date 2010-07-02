require ti-dvsdk-demos.inc

PV = "3_10_00_14"
PR = "${INC_PR}.1"

SRC_URI_append_dm365 = " file://dm365-demos-with-new-data-paths.patch \
    file://changed_insmod_to_modprobe_in_loadmodules_3.10.00.14.patch \
    file://remove-loadmodules_hd.sh-from-make-install_3.10.00.14.patch"

SRC_URI[dvsdkdemostarball.md5sum] = "36cd08c21a95a60ca6916f029f875bea"
SRC_URI[dvsdkdemostarball.sha256sum] = "a39bbb08e85fd0131dc725cd9c01586e14b58bc361401dfd122f23c5f5d8db71"
