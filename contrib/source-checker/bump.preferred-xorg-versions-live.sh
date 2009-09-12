DATE=`date +%Y%m%d`
DIR=/tmp/xorg-releases/${DATE}
PREFIX=http://xorg.freedesktop.org/releases/individual/
GRPS="app data doc driver font lib proto util xserver"
OETREE=/home/projects/OE/org.openembedded.dev
PREFS=${OETREE}/conf/distro/include/preferred-shr-versions.inc
PREFS_LIVE=${OETREE}/conf/distro/include/preferred-xorg-versions-live.inc
BBS=${OETREE}/recipes/xorg-
OUT_LOG=${DIR}.log
OUT_CMD=${DIR}.cmd

mkdir -p ${DIR}
cd ${DIR}

function latest {
  IN=$1
  OUT=$2
  echo "Parsing latest from ${IN} to ${OUT}"
  sed "s/<a href=\"/\nPKG=/g" ${IN} | grep "^PKG=" | sed "s/^\([^\"]*\)\">.*$/\1/g" | grep "bz2$" | sort -V > ${IN}.tmp
  for PKG in `sed "s/^\(.*\)-\([^-]*\)$/\1/g" ${IN}.tmp | sort -u`; do
    grep ${PKG} ${IN}.tmp | tail -n 1 >> ${OUT};
  done
}

function updateVersions {
  PKG=$1
  GRP=$2
  VER=$3
  PREF_VER=`grep "PREFERRED_VERSION_${PKG} " ${PREFS} | sed 's/.*= *//g; s/"//g'`
  BB_VER=`ls -1 ${BBS}${GRP}/${PKG}_*.bb 2>/dev/null | sed "s%${BBS}${GRP}/${PKG}_%%g; s%.bb$%%g" | grep -v git | grep -v svn | sort -V | tail -n 1`
  #echo ${GRP}/${PKG}/${VER} ${PREF_VER} ${BB_VER}
  echo "PREFERRED_VERSION_${PKG} ?= \"${VER}\"" >> ${PREFS_LIVE}
  if [[ -n ${PREF_VER} &&  ${PREF_VER} != ${VER} ]] ; then
    echo "pref: $GRP ${PKG} ${PREF_VER} -> ${VER}"  | tee -a ${OUT_LOG}
    echo sed -i "'s%^\(PREFERRED_VERSION_${PKG} *?*= *\).*$%\1\"${VER}\"%g'" ${PREFS} >> ${OUT_CMD}
  fi
  if [[ -z ${PREF_VER} ]] ; then
    echo "new pref ${GRP} ${PKG}/${VER}" | tee -a ${OUT_LOG}
    echo "echo \"PREFERRED_VERSION_${PKG} ?= \\\"${VER}\\\"\" >> ${PREFS}" >> ${OUT_CMD}
  fi
  if [[ -n ${BB_VER} && ${BB_VER} != ${VER} ]] ; then
    echo "bump: $GRP ${PKG} ${BB_VER} -> ${VER}" | tee -a ${OUT_LOG}
    echo "cp ${BBS}${GRP}/${PKG}_${BB_VER}.bb ${BBS}${GRP}/${PKG}_${VER}.bb" >> ${OUT_CMD}
  fi
  if [[ -z ${BB_VER} ]] ; then
    echo "new ${GRP} ${PKG}/${VER}" | tee -a ${OUT_LOG}
  fi
}

for GRP in ${GRPS}; do
  if [[ ! -e ${GRP}.html ]] ; then
    wget http://xorg.freedesktop.org/releases/individual/${GRP} -O ${GRP}.html
  fi
  latest ${GRP}.html ${GRP}.txt
  sed "s/PKG=/${GRP}\//g; s/-\([^-]*\).tar.bz2$/\/\1/g;" ${GRP}.txt | gawk '{ print tolower($0) }' >> latest.txt
done

sort -u latest.txt > latest.sort.txt
 
echo "#`date`" > ${PREFS_LIVE}
#cat << EOF > ${PREFS_LIVE}
#PREFERRED_VERSION_xserver-xorg ?= "1.6.999+git%"
#PREFERRED_VERSION_libdrm-glamo ?= "2.3.1+git%"
#PREFERRED_VERSION_mesa-dri-glamo ?= "7.5.1+git%"
#PREFERRED_VERSION_xf86-video-glamo ?= "1.0.0+git%"
#PREFERRED_VERSION_xf86-input-keyboard ?= "1.3.2+git%"
#PREFERRED_VERSION_xf86-input-mouse ?= "1.4.0+git%"
#EOF

echo "#`date`" > ${OUT_LOG}
echo "#`date`" > ${OUT_CMD}

cat latest.sort.txt | while read LINE; do
  #echo ${LINE};
  PKG=`echo ${LINE} | sed "s%^\(.*\)\/\(.*\)\/\(.*\)$%\2%g;"`
  GRP=`echo ${LINE} | sed "s%^\(.*\)\/\(.*\)\/\(.*\)$%\1%g;"`
  VER=`echo ${LINE} | sed "s%^\(.*\)\/\(.*\)\/\(.*\)$%\3%g;"`
  updateVersions ${PKG} ${GRP} ${VER}
  updateVersions ${PKG}-native ${GRP} ${VER}
done
