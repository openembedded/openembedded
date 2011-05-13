require efreet.inc

SRCREV = "56910"
PV = "1.0.999+svnr${SRCPV}"
PR = "${INC_PR}.0"

SRC_URI = "\
  ${E_SVN}/trunk;module=${SRCNAME};proto=http;scmdata=keep \
  file://changeset_trunk_r57435.patch;maxrev=57434 \
"
S = "${WORKDIR}/${SRCNAME}"
