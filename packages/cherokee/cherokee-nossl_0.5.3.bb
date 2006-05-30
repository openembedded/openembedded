include cherokee_${PV}.bb

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/cherokee-${PV}', '${FILE_DIRNAME}/cherokee', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

S = "${WORKDIR}/cherokee-${PV}"

EXTRA_OECONF = "--disable-tls --disable-static --disable-nls"
