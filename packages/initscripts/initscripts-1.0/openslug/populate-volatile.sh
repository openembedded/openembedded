#!/bin/sh

. /etc/default/rcS
CFGFILE="/etc/default/volatiles"

[ "${VERBOSE}" != "no" ] && echo "Populating volatile Filesystems."

cat ${CFGFILE} | grep -v "^#" |   \
while read LINE; do
  TTYPE=`echo ${LINE} | cut -d " " -f 1`
  TUSER=`echo ${LINE} | cut -d " " -f 2`
  TGROUP=`echo ${LINE} | cut -d " " -f 3`
  TMODE=`echo ${LINE} | cut -d " " -f 4`
  TNAME=`echo ${LINE} | cut -d " " -f 5`

  [ "${VERBOSE}" != "no" ] && echo "Checking for -${TNAME}-."

  [ "${TTYPE}" = "l" ] && {
    [ -e "${TNAME}" ] && {
      echo "Cannot create link over existing -${TNAME}-." >&2
      } || {
      TSOURCE=`echo ${LINE} | cut -d " " -f 6`
      [ "${VERBOSE}" != "no" ] && echo "Creating link -${TNAME}- pointing to -${TSOURCE}-."
      ln -s "${TSOURCE}" "${TNAME}"
      }
    continue
    }

  [ -L "${TNAME}" ] && {
    [ "${VERBOSE}" != "no" ] && echo "Found link."
    NEWNAME=`ls -l "${TNAME}" | sed -e 's/^.*-> \(.*\)$/\1/'`
    echo ${NEWNAME} | grep -v "^/" >/dev/null && {
      TNAME="`echo ${TNAME} | sed -e 's@\(.*\)/.*@\1@'`/${NEWNAME}"
      [ "${VERBOSE}" != "no" ] && echo "Converted relative linktarget to absolute path -${TNAME}-."
      } || {
      TNAME="${NEWNAME}"
      [ "${VERBOSE}" != "no" ] && echo "Using absolute link target -${TNAME}-."
      }
    }

  [ -e "${TNAME}" ] && {
    [ "${VERBOSE}" != "no" ] && echo "Target already exists. Skipping."
    continue
    }

  case "${TTYPE}" in
    "f")  [ "${VERBOSE}" != "no" ] && echo "Creating file -${TNAME}-."
          touch "${TNAME}"
	  ;;
    "d")  [ "${VERBOSE}" != "no" ] && echo "Creating directory -${TNAME}-."
          mkdir -p "${TNAME}"
	  # Add check to see if there's an entry in fstab to mount.
	  ;;
    *)    [ "${VERBOSE}" != "no" ] && echo "Invalid type -${TTYPE}-."
          continue
	  ;;
  esac

  chown ${TUSER} ${TNAME} || echo "Failed to set owner -${TUSER}- for -${TNAME}-." >&2
  chgrp ${TGROUP} ${TNAME} || echo "Failed to set group -${TGROUP}- for -${TNAME}-." >&2
  chmod ${TMODE} ${TNAME} || echo "Failed to set mode -${TMODE}- for -${TNAME}-." >&2

  done

