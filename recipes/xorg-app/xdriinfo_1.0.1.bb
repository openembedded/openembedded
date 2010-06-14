require xorg-app-common.inc
PE = "1"

DEPENDS += " virtual/libx11 glproto virtual/libgl"


SRC_URI[archive.md5sum] = "be3c5a9b242a57226b5bb5f22ec341ca"
SRC_URI[archive.sha256sum] = "f693977bdaea7eb6b095a6b6bc60b8a62110ecdef4c455211346e592f59c3772"
PR = "${INC_PR}.0"
