#!/bin/bash
DATE=`date +%Y%m%d`
SCRDIR=`dirname $0`
DIR=${SCRDIR}/${DATE}
PREFIX=http://www.x.org/releases/X11R7.5/src/
GRPS="app data doc driver font lib proto util xserver"
OETREE=${SCRDIR}/../..
PREFS_LIVE=${OETREE}/conf/distro/include/preferred-xorg-versions-X11R7.5-live.inc
BBS=${OETREE}/recipes/xorg-
OUT_LOG=${DIR}.log
OUT_CMD=${DIR}.cmd

export LC_ALL=c

mkdir -p ${DIR}

function latest {
  IN=$1
  OUT=$2
  echo "Parsing latest from ${IN} to ${OUT}"
  sed "s/<a href=\"/\nPKG=/g" ${IN} | grep "^PKG=" | sed "s/^\([^\"]*\)\">.*$/\1/g" | grep "bz2$" | sort -V > ${IN}.tmp
  for PKG in `sed "s/^\(.*\)-\([^-]*\)$/\1/g" ${IN}.tmp | sort -u`; do
    grep ${PKG} ${IN}.tmp | tail -n 1 | sed 's/xorg-server/xserver-xorg/g' >> ${OUT};
  done
}

function updateVersions {
  PKG=$1
  GRP=$2
  VER=$3
  BB_VER=`ls -1 ${BBS}${GRP}/${PKG}_*.bb 2>/dev/null | sed "s%${BBS}${GRP}/${PKG}_%%g; s%.bb$%%g" | grep -v X11R7.0 | grep -v cvs | grep -v git | grep -v svn | sort -V | tail -n 1`
  #echo ${GRP}/${PKG}/${VER} ${PREF_VER} ${BB_VER}
  if ls -1 ${BBS}${GRP}/${PKG}_*.bb >/dev/null 2>/dev/null ; then
    echo "PREFERRED_VERSION_${PKG} ?= \"${VER}\"" >> ${PREFS_LIVE}
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
  if [[ ! -e ${DIR}/${GRP}.html ]] ; then
    wget ${PREFIX}/${GRP} -O ${DIR}/${GRP}.html
  fi
  latest ${DIR}/${GRP}.html ${DIR}/${GRP}.txt
  echo "#${GRP}" >> ${DIR}/latest.txt
  sed "s/PKG=/${GRP}\//g; s/-\([^-]*\).tar.bz2$/\/\1/g;" ${DIR}/${GRP}.txt | gawk '{ print tolower($0) }' >> ${DIR}/latest.txt
done

sort -u ${DIR}/latest.txt > ${DIR}/latest.sort.txt
 
echo "#`date`" > ${PREFS_LIVE}

echo "#`date`" > ${OUT_LOG}
echo "#`date`" > ${OUT_CMD}

cat ${DIR}/latest.txt | while read LINE; do
  if [[ ${LINE} =~ \#.* ]]; then
    echo ${LINE} >> ${PREFS_LIVE}
    continue
  fi
  #echo ${LINE};
  PKG=`echo ${LINE} | sed "s%^\(.*\)\/\(.*\)\/\(.*\)$%\2%g;"`
  GRP=`echo ${LINE} | sed "s%^\(.*\)\/\(.*\)\/\(.*\)$%\1%g;"`
  VER=`echo ${LINE} | sed "s%^\(.*\)\/\(.*\)\/\(.*\)$%\3%g;"`
  updateVersions ${PKG} ${GRP} ${VER}
  updateVersions ${PKG}-native ${GRP} ${VER}
done

echo "Check ${OUT_LOG} if there is something new and interesting"
echo "You can update prefs or copy bbfiles with commands from ${OUT_CMD}"
