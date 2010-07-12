require gnumail_${PV}.bb

inherit native

DEPENDS = "fastjar-native gnujaf-native inetlib-native"

EXTRA_OECONF = "\
  --with-inetlib-jar=${STAGING_DATADIR}/java \
  --with-activation-jar=${STAGING_DATADIR}/java \
  "
