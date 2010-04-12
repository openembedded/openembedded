DESCRIPTION = "R is GNU S, a freely available language and environment for statistical computing and \
graphics which provides a wide variety of statistical and graphical techniques: \
linear and nonlinear modelling, statistical tests, time series analysis, classification, clustering, etc."

SRC_URI = "http://cran.r-mirror.de/src/base/R-${PV}.tgz"
S = "${WORKDIR}/R-${PV}"

inherit autotools

SRC_URI[md5sum] = "c8201425506e5c077ef1936e19ea2f51"
SRC_URI[sha256sum] = "61a5f417ec5e2bbd2ae5280e79f860f718d4c179539c71873eddb614f72e3b56"
