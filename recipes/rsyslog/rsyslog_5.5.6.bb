require rsyslog.inc
PR = "${INC_PR}.0"

SRC_URI += " file://rsyslog-resume.patch "

SRC_URI[md5sum] = "835a7dd4f404d37c9d01a1056beaf3cb"
SRC_URI[sha256sum] = "ae866e1f92869b82cf30270cbea192dbc5229c8707a8782fff95641bcb5725a2"
