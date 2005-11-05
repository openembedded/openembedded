/*
 * Copyright (C) 2003 Philip Blundell <philb@gnu.org>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version
 * 2 of the License, or (at your option) any later version.
 */

#include <stdlib.h>
#include <string.h>
#include <glib.h>
#include <assert.h>

#include "libdisplaymigration/auth.h"
#include "libdisplaymigration/crypt.h"

static gcry_mpi_t
mpi_from_sexp (gcry_sexp_t r, char *tag)
{
  gcry_sexp_t s = gcry_sexp_find_token (r, tag, 0);
  return gcry_sexp_nth_mpi (s, 1, GCRYMPI_FMT_USG);
}

static char *
hex_from_mpi (gcry_mpi_t m)
{
  char *buf;
  gcry_mpi_aprint (GCRYMPI_FMT_HEX, (void *)&buf, NULL, m);
  return buf;
}

void
displaymigration_crypt_create_hash (char *display, char *challenge, size_t len, char *result)
{
  size_t dlen = strlen (display);
  gchar *buf = g_malloc (dlen + 1 + len);
  strcpy (buf, display);
  memcpy (buf + dlen + 1, challenge, len);
  gcry_md_hash_buffer (GCRY_MD_SHA1, result, buf, len + dlen + 1);
  g_free (buf);
}

static int
do_encode_md (const unsigned char *digest, size_t digestlen, int algo,
              unsigned int nbits, gcry_mpi_t *r_val)
{
  int nframe = (nbits+7) / 8;
  unsigned char *frame;
  int i, n;
  unsigned char asn[100];
  size_t asnlen;

  asnlen = sizeof(asn);
  if (gcry_md_algo_info (algo, GCRYCTL_GET_ASNOID, asn, &asnlen))
    return -1;

  if (digestlen + asnlen + 4  > nframe )
    return -1;
  
  /* We encode the MD in this way:
   *
   *	   0  1 PAD(n bytes)   0  ASN(asnlen bytes)  MD(len bytes)
   *
   * PAD consists of FF bytes.
   */
  frame = g_malloc (nframe);
  n = 0;
  frame[n++] = 0;
  frame[n++] = 1; /* block type */
  i = nframe - digestlen - asnlen -3 ;
  assert ( i > 1 );
  memset ( frame+n, 0xff, i ); n += i;
  frame[n++] = 0;
  memcpy ( frame+n, asn, asnlen ); n += asnlen;
  memcpy ( frame+n, digest, digestlen ); n += digestlen;
  assert ( n == nframe );
      
  gcry_mpi_scan (r_val, GCRYMPI_FMT_USG, frame, nframe, &nframe);
  g_free (frame);
  return 0;
}

gboolean
displaymigration_crypt_sign_hash (struct rsa_key *k, char *hash, gchar **result)
{
  gcry_mpi_t mpi;
  gcry_sexp_t data, sig, key;
  int rc;
  char *hex;

  do_encode_md (hash, 20, GCRY_MD_SHA1, 1024, &mpi);

  if (gcry_sexp_build (&data, NULL, "(data (value %m))", mpi))
    return FALSE;
 
  gcry_mpi_release (mpi);

  if (gcry_sexp_build (&key, NULL, "(private-key (rsa (n %m) (e %m) (d %m) (p %m) (q %m) (u %m)))",
		       k->n, k->e, k->d, k->p, k->q, k->u))
    {
      gcry_sexp_release (data);
      return FALSE;
    }
  
  rc = gcry_pk_sign (&sig, data, key);

  gcry_sexp_release (data);
  gcry_sexp_release (key);

  if (rc)
    return FALSE;

  mpi = mpi_from_sexp (sig, "s");
  hex = hex_from_mpi (mpi);
  *result = g_strdup (hex);
  gcry_free (hex);
  gcry_mpi_release (mpi);
  gcry_sexp_release (sig);

  return TRUE;
}

gboolean
displaymigration_crypt_check_signature (struct rsa_key *k, char *hash, char *sigbuf)
{
  gcry_mpi_t mpi, mpi2;
  gcry_sexp_t data, sig, key;
  int rc;

  do_encode_md (hash, 20, GCRY_MD_SHA1, 1024, &mpi);

  gcry_sexp_build (&data, NULL, "(data (value %m))", mpi);
  
  gcry_mpi_release (mpi);

  gcry_sexp_build (&key, NULL, "(public-key (rsa (n %m) (e %m)))", k->n, k->e);

  if (gcry_mpi_scan (&mpi2, GCRYMPI_FMT_HEX, sigbuf, 0, NULL))
    {
      gcry_sexp_release (data);
      return FALSE;
    }

  gcry_sexp_build (&sig, NULL, "(sig-val (rsa (s %m)))", mpi2);

  rc = gcry_pk_verify (sig, data, key);

  gcry_sexp_release (data);
  gcry_sexp_release (key);
  gcry_sexp_release (sig);
  gcry_mpi_release (mpi2);

  if (rc)
    return FALSE;

  return TRUE;
}
