//*****************************************************************************
// copyright (c) 1998-2003 TLK Games all rights reserved
//-----------------------------------------------------------------------------
// file         : "linuxroutines.cpp"
// created      : 1999-08-19
// updates      : 2004-08-01 
//------------------------------------------------------------------------------
// functions    :  int              mem_initialise(unsigned int _iNombreZones)
//                 char*            reserveMemoire(unsigned int _iTailleMemoire)
//                 void             libereMemoire(char* _pMemoire)
//                 void             mem_libereTous()
//                 int              load_pcx(char*, char*) ;
//                 sDescriptionGfx* load_pcx(char*) ;
//                 unsigned int     littleWord(char* _pMem) ;
//                 short            litMot16bits(short* _pMem) ;
//                 int              litMot32bits(int* _pMem) ;
//                 int              chaine_cmp(char* _pChaine1, char* _pChaine2, unsigned int _iTaille) ;
//                 char*            chargeFichier(char* _pNomFichier)
//                 char*            chargeFichier(char* _pNomFichier, unsigned int* pTaille)
//                 int              chargeFichier(char* _pNomFichier, char* _pMemoire)
//                 void             fps_init()
//                 void             fps_affiche() 
//                 void             afficheErreur(char* _pErreur1, char* _pErreur2)
//                 int              synchro_processusPause(int _iTemps)
//                 int              synchro_CalculDifference()
//                 int              synchro_CalculDifference2()
//-----------------------------------------------------------------------------
// This program is free software; you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation; either version 2 of the License, or (at your option) any later
// version.
// 
// This program is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program; if not, write to the Free Software Foundation, Inc., 59 Temple
// Place - Suite 330, Boston, MA  02111-1307, USA.
//
//*****************************************************************************

#include "powermanga.hpp"
#include <errno.h>

#ifndef SDL_TLK
#include <sys/types.h>
#include <sys/stat.h>
#endif

//..............................................................................
extern unsigned int     iVerbeux;                              //1=affiche les arguments / 1=verbose mode

//gestion de la memoire .........................................................
typedef struct
{ char *pMemoire;                                              //pointeur sur la zone memoire / pointer to memory zone
  int   iTailleMemoire;                                         //taille de la zone en octets / size of memory zone in bytes
}
sListeMemoire;
char                   *pZoneListeMemoire;
sListeMemoire          *pZoneListeBase;
sListeMemoire          *pZoneListeLibre;
unsigned int            iTailleListe;                          //taille de la liste memoire / size of memory table             
unsigned int            iNombreZonesMaximum;                   //nombre de zones memoires maxi / number maximum of memory zone
unsigned int            iNombreZones;                          //nombre de zone actuelle       / number of memroy zone
unsigned int            iOctetsTotal;                          //taille prise en octets        / total memory size allocated           
unsigned int            iNombreZonesMax;                       //nombre maximum de zones reserves

//..............................................................................
unsigned int            iCompteurBoucle;
#ifdef SDL_TLK 
Uint32                  time_begin;
Uint32                  temps_actuel;
Uint32                  temps_sauve;
Uint32                  temps_actuel2;
Uint32                  temps_sauve2;
#else
static struct timeval   time_begin;
static struct timeval   temps_actuel;
static struct timeval   temps_sauve;
static struct timeval   temps_actuel2;
static struct timeval   temps_sauve2;
#endif

//..............................................................................
short                   litMot16bitsBig(short *_pMem);
unsigned short          litMot16bits(unsigned short *_pMem);
extern const char       nomprefix[];
extern unsigned int     iFrame3; 
//------------------------------------------------------------------------------
// initialise la liste memoire / initialise memory table
// input =>  _iNombreZones : nombre de zones memoire possibles au maximum / number maximum of memory zone
// ouput <= 0=erreur / 0=error
//------------------------------------------------------------------------------
int mem_initialise(unsigned int _iNombreZones)
{
  unsigned int _iIndex;
  iNombreZones = 0;                                            // nombre de zones reservees a zero
  pZoneListeMemoire = 0;
  iNombreZonesMaximum = _iNombreZones;                         // nombre maximum de zones pouvant etre reservees 
  iNombreZonesMax = 0;
  iTailleListe = iNombreZonesMaximum * sizeof(sListeMemoire);
  iOctetsTotal = iTailleListe;
  pZoneListeMemoire = (char *)malloc(iTailleListe);
  if(!pZoneListeMemoire)
  { afficheErreur("malloc() failed", "linuxroutines/mem_initialise()");
    return 0;
  }
  pZoneListeBase = (sListeMemoire *) pZoneListeMemoire;
  pZoneListeLibre = pZoneListeBase;
  sListeMemoire          *_pMem = pZoneListeBase;

  for(_iIndex = 0; _iIndex < iNombreZonesMaximum; _iIndex++, _pMem++)   //clean memory table
  { _pMem->pMemoire = 0x0;
    _pMem->iTailleMemoire = 0x0;
  }
  return 1;
}

//------------------------------------------------------------------------------
// reserve une zone memoire / allocate memory
// input  => _iTailleMemoire : taille memoire en octets souhaitee / size of bytes
// output <= _pMem           : adresse memoire (0=erreur) / pointer to memory
//------------------------------------------------------------------------------
char *reserveMemoire(unsigned int _iTailleMemoire)
{
  char                   *_pMem = 0x0;
  char                   *_pMemoire = 0x0;
  char                    _cZero = 0;
  unsigned int            _iIndex;
  if(iNombreZones >= iNombreZonesMaximum)
  { printf ("linuxroutines.cpp/reserveMemoire(unsigned int) : table overflow ; size request %i bytes ; total allocate : % i in %i zones\n", _iTailleMemoire, iOctetsTotal, iNombreZones);
    return 0;
  }
  _pMem = (char *)malloc(_iTailleMemoire);
  if(!_pMem)
  { printf ("linuxroutines.cpp/reserveMemoire(unsigned int) : malloc(int) return 0 ; size request %i bytes ; total allocate : % i in %i zones\n", _iTailleMemoire, iOctetsTotal, iNombreZones);
    return 0;
  }
  iOctetsTotal += _iTailleMemoire;
  pZoneListeLibre->pMemoire = _pMem;                           //pointeur memoire      
  pZoneListeLibre->iTailleMemoire = _iTailleMemoire;           //taille en octets      
  pZoneListeLibre += 1;
  iNombreZones++;
  if(iNombreZones > iNombreZonesMax)
      iNombreZonesMax = iNombreZones; 
  _pMemoire = _pMem;
  for(_iIndex = 0; _iIndex < _iTailleMemoire; _iIndex++)
    *(_pMemoire++) = _cZero;                                   //efface memoire        
  return (_pMem);
}

//------------------------------------------------------------------------------
// liberation d'une zone memoire / free memory
// input => _pMemoire : adresse de la zone a liberer / pointer to memory
//------------------------------------------------------------------------------
void libereMemoire(char *_pMemoire)
{
  sListeMemoire          *_pListeMem;
  sListeMemoire          *_pListeMemSource;
  unsigned int            _iCompteur;
  if(_pMemoire)
  { _pListeMem = pZoneListeBase;
    for(_iCompteur = 0; _iCompteur < iNombreZones; _iCompteur++, _pListeMem++)
    { if(_pListeMem->pMemoire == _pMemoire)                    //on a trouve l'adresse dans la table ?
      { free(_pMemoire);                                       //oui, libere la memoire                                
        _pListeMemSource = _pListeMem + 1;
        iOctetsTotal -= _pListeMem->iTailleMemoire;
        iNombreZones--;
        pZoneListeLibre--;
        while (_iCompteur < iNombreZones)
        { _pListeMem->pMemoire = _pListeMemSource->pMemoire;
          _pListeMem->iTailleMemoire = _pListeMemSource->iTailleMemoire;
          _iCompteur++;
          _pListeMem++;
          _pListeMemSource++;
        }
        _pListeMem->pMemoire = 0x0;
        _pListeMem->iTailleMemoire = 0x0;
        _pMemoire = 0;
        break;
      }
    }
    if(_pMemoire > 0)
    { fprintf(stderr, "libereMemoire() : can't release the address %x\n", (int)_pMemoire);
    }
  }
  else
  { fprintf(stderr, "libereMemoire() : try to release a null address!\n");  
  }
}

//------------------------------------------------------------------------------
// retourne la taille d'une adresse memoire reservee / get memory zone's size
// input => _pMem : pointeur sur une zone memoire / pointer to memory
//------------------------------------------------------------------------------
int mem_retourneTaille(char *_pMem)
{
  unsigned int            _iCompteur;
  sListeMemoire          *_pListeMem = pZoneListeBase;
  if(_pMem)
  { for(_iCompteur = 0; _iCompteur < iNombreZones; _iCompteur++, _pListeMem++)
    { if(_pListeMem->pMemoire == _pMem)
        return _pListeMem->iTailleMemoire;
    }
  }
  return 0;
}

//------------------------------------------------------------------------------
// libere toutes les zones memoires / free all memory
//------------------------------------------------------------------------------
void mem_libereTous()
{
  unsigned int _iCompteur;
  char *_pMemoire;
  sListeMemoire *_pListeMem = pZoneListeBase;
#ifdef _VERBEUX_
  if(iVerbeux > 0)
    fprintf(stdout, "> linuxroutines.cpp/mem_libereTous(): maximum of memory which were allocated during the game : %i\n", iNombreZonesMax);
#endif
  if(iNombreZones >0)
  { 
#ifdef _VERBEUX_
    if(iVerbeux > 0)
      fprintf(stdout, "> linuxroutines.cpp/mem_libereTous() : %i zones were not released.\n", iNombreZones);
#endif
    for(_iCompteur = 0; _iCompteur < iNombreZones; _iCompteur++, _pListeMem++)
    { _pMemoire = _pListeMem->pMemoire;
      if(_pMemoire)
      { /* fprintf(stderr, "mem_libereTous: adresseMem =%x ; taille_mem=%ld\n", 
          (int)_pListeMem->pMemoire, _pListeMem->iTailleMemoire); */
        free(_pMemoire); //libere la memoire                             
        _pListeMem->pMemoire = 0;
        _pListeMem->iTailleMemoire = 0;
      }
    }
    if(pZoneListeMemoire)
    { free(pZoneListeMemoire);
      pZoneListeMemoire = 0x0;
    }
    iNombreZones = 0;
  }
}

//------------------------------------------------------------------------------
// decompress pcx file 
// input  =>  _pFichier     : filename
// output <= _pStructureGfx : pointer to the "sDescriptionGfx" structure / 0=error 
//------------------------------------------------------------------------------
sDescriptionGfx *load_pcx(char *_pNomFichier)
{
  unsigned int            iLongeur;
  unsigned int            ptr = 128;
  unsigned char           nbr_bytes;
  unsigned char           val;
  unsigned int            i1, i, total;
  unsigned char          *_pFichier, *_pAdresseMem;
  sDescriptionGfx        *_pDescripGfx = 0x0;
  _pFichier = (unsigned char *)chargeFichier(_pNomFichier, &iLongeur);  //load file in memory
  if(!_pFichier) return 0;
  unsigned short         *_p16 = (unsigned short *)_pFichier;
  unsigned int            _iLarge = (litMot16bits(_p16 + 4) - litMot16bits(_p16 + 2)) + 1;      //image width
  unsigned int            _iHaut = (litMot16bits(_p16 + 5) - litMot16bits(_p16 + 3)) + 1;       //image height
  unsigned int            _iProfondeur = _pFichier[3];         //bits per pixel

  _pDescripGfx = (sDescriptionGfx *) reserveMemoire(sizeof(sDescriptionGfx));   //allocate structure memory
  if(!_pDescripGfx)
  { afficheErreur("_pDescripGfx out of memory", "linuxroutines.cpp/load_pcx()");
    return 0;
  }
  _pDescripGfx->iLargeur = _iLarge;
  _pDescripGfx->iHauteur = _iHaut;
  _pDescripGfx->iProfond = _iProfondeur;
  _pDescripGfx->iTaille = _iLarge * _iHaut * (_iProfondeur >> 3);
  _pDescripGfx->pAdresse = reserveMemoire(_pDescripGfx->iTaille);       //allocate image memory
  if(!_pDescripGfx->pAdresse)
  { libereMemoire((char *)_pDescripGfx);
    printf("linuxroutines.cpp/load_pcx() : height=%i / width=%i \n", _iLarge, _iHaut);
    afficheErreur("_pDescripGfx->iTaille : out of memory\n", "linuxroutines.cpp/reserveMemoire()");
    return 0;
  }
  //decompress rle
  _pAdresseMem = (unsigned char *)_pDescripGfx->pAdresse;
  total = 0;
  i = iLongeur - 768;
  while (ptr < i)
  { if((_pFichier[ptr] & 0xC0) == 0xC0)
    { nbr_bytes = _pFichier[ptr] & 0x3F;
      ptr++;
    }
    else
      nbr_bytes = 1;
    val = _pFichier[ptr];
    total += nbr_bytes;                  // Samuel Hocevar
    if(total >= _pDescripGfx->iTaille)
    break;
    for(i1 = 0; i1 < nbr_bytes; i1++)
    { *_pAdresseMem = val;
      _pAdresseMem++;
    }
    ptr++;
  }
  libereMemoire((char *)_pFichier);
#ifdef _VERBEUX_
  if(iVerbeux > 0)
    fprintf (
      stdout,
      "> linuxroutines.cpp/load_pcx(): \"%s\"; height=%i; width=%i; size=%i\n",
      _pNomFichier,
      _iLarge,
      _iHaut,
      _pDescripGfx->iTaille);
#endif
  return _pDescripGfx;
}

//------------------------------------------------------------------------------
// lecture d'un mot de 16 bits code en memoire en little-endian
// input  => _pMem    : pointeur sur le mot en memoire
// output <= _iValeur : valeur utilisale
//------------------------------------------------------------------------------
unsigned int littleWord(char *_pMem)
{
  unsigned short *t = (unsigned short *)_pMem;
  return *t;
}

//------------------------------------------------------------------------------
// lecture d'un long mot signe de 16 bits little-endian (compatible little-endian/big-endian)
// input  => _pMem    : pointeur sur le mot en memoire
// output <= _iValeur : valeur utilisale
//------------------------------------------------------------------------------
short litMot16bits(short *_pMem)
{
  short  _iValeur = 0;
  unsigned char  *_pMemoire = (unsigned char *)_pMem;
  _iValeur = _pMemoire[1];                                     //lit du little endian pour un powerpc
  _iValeur <<= 8;
  _iValeur += _pMemoire[0];
  return (_iValeur);
}

//------------------------------------------------------------------------------
// lecture d'un long mot signe de 16 bits little-endian (compatible little-endian/big-endian)
// input  => _pMem    : pointeur sur le mot en memoire
// output <= _iValeur : valeur utilisale
//------------------------------------------------------------------------------
unsigned short litMot16bits(unsigned short *_pMem)
{
  unsigned short          _iValeur = 0;
  unsigned char          *_pMemoire = (unsigned char *)_pMem;
  _iValeur = _pMemoire[1];                                     //lit du little endian pour un powerpc
  _iValeur <<= 8;
  _iValeur += _pMemoire[0];
  return (_iValeur);
}

//------------------------------------------------------------------------------
// lecture d'un long mot signe de 16 bits big-endian (compatible little-endian/big-endian)
// input => _pMem    : pointeur sur le mot en memoire
// output <= _iValeur : valeur utilisale
//------------------------------------------------------------------------------
short litMot16bitsBig(short *_pMem)
{
  short                   _iValeur = 0;
  unsigned char          *_pMemoire = (unsigned char *)_pMem;
  _iValeur = _pMemoire[0];                                     //lit du big endian pour un 80x86
  _iValeur <<= 8;
  _iValeur += _pMemoire[1];
  return (_iValeur);
}

//------------------------------------------------------------------------------
//lecture d'un long mot signe de 32 bits little-endian(compatible little-endian/big-endian)
// input  => _pMem    : pointeur sur le mot 32 bits en memoire
// output <= _iValeur : valeur utilisale
//------------------------------------------------------------------------------
int litMot32bits(int *_pMem)
{
  int                     _iValeur = 0;
  unsigned char          *_pMemoire = (unsigned char *)_pMem;
  _iValeur = _pMemoire[3];
  _iValeur <<= 8;
  _iValeur += _pMemoire[2];
  _iValeur <<= 8;
  _iValeur = _pMemoire[1];
  _iValeur <<= 8;
  _iValeur += _pMemoire[0];
  return (_iValeur);
}

//------------------------------------------------------------------------------
// convertit un long mot de 32 bits en memoire little-endian => big-endian
//------------------------------------------------------------------------------
void convert32bits_2bigendian (unsigned char* memory)
{ unsigned char b0, b1, b2, b3;
  b0 = memory[1];
  b1 = memory[0];
  b2 = memory[3];
  b3 = memory[2];
  memory[0] = b2;
  memory[1] = b3;
  memory[2] = b0;
  memory[3] = b1;
}

//------------------------------------------------------------------------------
//comparaison de deux chaines de caracteres
// input  => _pChaine1 : pointeur sur la premiere chaine
//        => _pChaine1 : pointeur sur la deuxieme chaine
//        => _iTaille  : longeurs en octets de chaines
// output <= 0les chaines ont au moins une difference / 1=les chaines sont identiques
//------------------------------------------------------------------------------
int chaine_cmp(char *_pChaine1, char *_pChaine2, unsigned int _iTaille)
{
  unsigned int            _iLongeur = _iTaille;
  char                   *_pMem1 = _pChaine1;
  char                   *_pMem2 = _pChaine2;
  unsigned int            _iIndex;
  char                    _cOctet1, _cOctet2;
  for(_iIndex = 0; _iIndex < _iLongeur; _iIndex++)
  { _cOctet1 = _pMem1[_iIndex];
    _cOctet2 = _pMem2[_iIndex];
    if(_cOctet2 != _cOctet1)
      return (0);
  }
  return (1);
}

//------------------------------------------------------------------------------
// locate a file under one of the data directories (thanx to Andre Majorel :-)
// input  =>  name : name of file relative to data directory
// output <=  0    : could not locate file (not found, or not enough
//                   memory, or the name given was absolute)
// other           : pointer to a malloc'd buffer containing the name
//                   under which the file was found. free()-ing the
//                   buffer is the responsibility of the caller.
//------------------------------------------------------------------------------
static const char      *data_directories[]=
{ ".",                                                         // Normally unused, except when running from the source directory...
  "/opt/QtPalmtop/share/games/powermanga/",
  0                                                            // Special value meaning "$(PREFIX)/share/games/powermanga/"
                                                               // Also marks end of list
};
static char pathstring[256];

char *locate_data_file(const char *const name)
{
  
  for(int i = 0; i < 256; i++)
	pathstring[i] = 0;
	
  if(name == 0) return 0;
  if(*name == '/') return strdup(name);                        // Guillaume Cottenceau (2001-03-15) replace "return 0;" by "strdup(name);"
                                                               // En effet, nous sommes dans le cas ou le programme recherche dans /usr/share/games/powermanga
  for(const char **p = data_directories;; p++)
  { char *pathname;
    if(*p == 0)
    { const char *subdir = "/share/games/powermanga/";
      pathname = &pathstring[0];
      /*pathname=(char *)malloc(strlen(nomprefix) + strlen(subdir) + strlen(name) + 1);
      if(pathname == 0)
      { fflush(stdout);
        fprintf(stderr, "powermanga: not enough memory\n");
        return 0;
      }*/
      strcpy(pathname, nomprefix);
      strcat(pathname, subdir);
      strcat(pathname, name);
    }
    else if(**p == '~')                                        // Not used anymore
    { static const char       bogus = '\0';
      static const char      *home_dir = &bogus;
      if(home_dir == &bogus) home_dir = getenv("HOME");
      if(home_dir == 0) continue;                             // $HOME not set. Skip this directory.
      pathname = &pathstring[0];
      
      /*pathname = (char *)malloc(strlen(home_dir) + 1 + strlen(*p + 1) + 1 + strlen(name) + 1);
      if(pathname == 0)
      { fflush(stdout);
        fprintf(stderr, "powermanga: not enough memory\n");
        return 0;
      }*/
      strcpy(pathname, home_dir);
      strcat(pathname, *p + 1);
      strcat(pathname, "/");
      strcat(pathname, name);
    }
    else
    {
      pathname = &pathstring[0];
      /*pathname = (char *)malloc(strlen(*p) + 1 + strlen(name) + 1);
      if(pathname == 0)
      { fflush(stdout);
        fprintf(stderr, "powermanga: not enough memory\n");
        return 0;
      }*/
      strcpy(pathname, *p);
      strcat(pathname, "/");
      strcat(pathname, name);
    }
    //puts(pathname);  // DEBUG
#ifdef WIN32
    struct _stat s;
    if(_stat(pathname, &s) == 0 && !_S_ISDIR(s.st_mode))
      return pathname;
#else
    struct stat s;
    if(stat(pathname, &s) == 0 && !S_ISDIR(s.st_mode))
      return pathname;
#endif
    //free(pathname);
    if(*p == 0) break;
  }
  return 0;                                                    // Not found.
}

//------------------------------------------------------------------------------
// load a file in memory / charge un fichier en memoire
// input =>  _pNomFichier  : nom du fichier
//           _pAdresse     : adresse de chargemebt
//           _iTaille      : taille a lire
// output <= 1             : tout c'est bien passe
//           0             : erreur
//------------------------------------------------------------------------------
char *chargeFichier(char *_pNomFichier)
{
  unsigned int            _pTaille;
  return chargeFichier(_pNomFichier, &_pTaille);
}

//------------------------------------------------------------------------------
// load a file in memory 
// input => _pNomFichier : filename
// sortie <= _pMemoire   : ptr/integer 
//------------------------------------------------------------------------------
char *chargeFichier(char *_pNomFichier, unsigned int *pTaille)
{
  int _iHandle;
  char *_pMemoire;
  struct stat sDescriptionFichier;
  char *pathname = locate_data_file(_pNomFichier);
  if(pathname == 0)
  { printf("linuxroutines/chargeFichier() : can't locate file : %s\n\n", _pNomFichier);
    return 0;
  }
#ifdef WIN32
  _iHandle = open(pathname, O_RDONLY | O_BINARY, 0); 
#else
  _iHandle = open(pathname, O_RDONLY, 0); 
#endif
  if(_iHandle == -1)
  { printf("linuxroutines/chargeFichier() : can't open file : %s (%s)\n\n", pathname, strerror(errno));
    //free(pathname);
    return 0;
  }
  if(fstat(_iHandle, &sDescriptionFichier))
  { printf("linuxroutines/chargeFichier() : can't stat file : %s (%s)\n\n", pathname, strerror(errno));
    close(_iHandle);
    //free(pathname);
    return 0;
  }
  (*pTaille) = sDescriptionFichier.st_size;                    //sauve taille
  _pMemoire = reserveMemoire(sDescriptionFichier.st_size);     //reserve la place en memoire pour lire le fichier
  if(!_pMemoire)
  { printf("linuxroutines/chargeFichier() %s : out of memory\n\n", pathname);
    close(_iHandle);
    //free(pathname);
    return 0;
  }
  if(read(_iHandle, _pMemoire, sDescriptionFichier.st_size) != sDescriptionFichier.st_size)
  { libereMemoire(_pMemoire);
    printf("linuxroutines/chargeFichier() can't read file %s (%s)\n\n", pathname, strerror(errno));
    close(_iHandle);
    //free(pathname);
    return 0;
  }
  close(_iHandle);
#ifdef _VERBEUX_
  if(iVerbeux > 1)
    printf("linuxroutines/chargeFichier : file %s was loaded in memory\n", pathname);
#endif
  //free(pathname);
  return _pMemoire;
}

//------------------------------------------------------------------------------
// load a file in memory / charge un fichier en memoire
// input   => _pNomFichier : filename / nom du fichier
//         => _pMemoire    : pointer to memory / pointeur sur la memoire   
// output <= 1             : 0 error/erreur
//------------------------------------------------------------------------------
int chargeFichier(char *_pNomFichier, char *_pMemoire)
{
  int                     _iHandle;
  struct stat             sDescriptionFichier;
  char                   *pathname = locate_data_file(_pNomFichier);
  if(pathname == 0)
  { printf("linuxroutines/chargeFichier() : can't locate file : %s\n\n", _pNomFichier);
    return 0;
  }
#ifdef WIN32
  _iHandle = open(pathname, O_RDONLY | O_BINARY, 0); 
#else
  _iHandle = open(pathname, O_RDONLY, 0); 
#endif
  if(_iHandle == -1)
  { printf ("linuxroutines.cpp/chargeFichier() : can't open file : %s (%s)\n\n", pathname, strerror(errno));
    //free(pathname);
    return 0;
  }
  if(fstat(_iHandle, &sDescriptionFichier))
  { printf ("linuxroutines.cpp/chargeFichier() : can't stat file : %s (%s)\n\n", pathname, strerror(errno));
    close(_iHandle);
    //free(pathname);
    return 0;
  }
  if(read(_iHandle, _pMemoire, sDescriptionFichier.st_size) != sDescriptionFichier.st_size)
  { printf("linuxroutines.cpp/chargeFichier() can't read file %s (%s)\n\n", pathname, strerror(errno));
    close(_iHandle);
    //free(pathname);
    return 0;
  }
  close(_iHandle);
#ifdef _VERBEUX_
  if(iVerbeux > 1) printf("linuxroutines/chargeFichier : file %s was loaded in memory\n", pathname);
#endif
  //free(pathname);
  return 1;
}

//------------------------------------------------------------------------------
// initialise le compteur de boucle et l'heure de depart du programme
//------------------------------------------------------------------------------
void fps_init()
{
#ifdef SDL_TLK 
  time_begin = SDL_GetTicks();
  temps_sauve = SDL_GetTicks();
  temps_sauve2 = SDL_GetTicks();
#else
  gettimeofday(&time_begin, NULL);
  gettimeofday(&temps_sauve, NULL);
  gettimeofday(&temps_sauve2, NULL);
#endif
  iCompteurBoucle = 0;
}

//------------------------------------------------------------------------------
// affiche information sur le systeme
//------------------------------------------------------------------------------
void fps_affiche()
{
  
#ifdef SDL_TLK
  double fps;
  unsigned long duration;
  Sint32 time_end; 
  time_end = SDL_GetTicks();
  duration = time_end - time_begin;
  fps = (1000.0 * iCompteurBoucle) / duration;
  if(iVerbeux > 0)
  { printf("> linuxroutines.cpp/number of loops : %i\n", iCompteurBoucle);
    printf("> linuxroutines.cpp/running time    : %li\n", duration);
    printf("> linuxroutines.cpp/fps_affiche()   : frames per seconde : %g \n", fps);
  }
#else  
  struct utsname          kernel;
  struct stat             statmem;
  unsigned long           duration;
  double                  fps;
  double                  mem;
  char                    os_name[32];
  char                    os_vers[32];
  char                    cpu[64];
  char                    freq[32];
  FILE                   *cpuinfo;
  char                    txt[256];
  static struct timeval   time_end;

  //calcul le temps total d'execution ............................................
  gettimeofday(&time_end, NULL);
  duration = (time_end.tv_sec - time_begin.tv_sec) * 1000 + (time_end.tv_usec - time_begin.tv_usec) / 1000;
  fps = (1000.0 * iCompteurBoucle) / duration;

  //version du systeme d'exploitation ............................................
  if(uname(&kernel) < 0)
  { strcpy(os_name, "?");
    strcpy(os_vers, "");
  }
  else
  { strncpy(os_name, kernel.sysname, 32);
    strncpy(os_vers, kernel.release, 32);
  }
  //processeur & memoire physique du systeme .....................................
  stat("/proc/kcore", &statmem);
  mem = ((float)statmem.st_size) / 1024 / 1024;
  strcpy(cpu, "Unknown");
  strcpy(freq, "Unknown");
  cpuinfo = fopen("/proc/cpuinfo", "r");
  if(cpuinfo != NULL)
  { while (fgets(txt, 255, cpuinfo))
    { if(!strncmp(txt, "model", 5))
      { int                     i = 0;
        while (txt[i] != ':') i++;
        i += 2;
        for(int j = 0; j < 64;)
        { if(txt[i++] != '\n') cpu[j++] = txt[i - 1];
        }
      }
      if(!strncmp(txt, "cpu MHz", 7))
      { int                     i = 0;
        while (txt[i] != ':') i++;
        i += 2;
        sprintf(freq, "%d", atoi(txt + i));
      }
    }
  }
  //processeur & memoire physique du systeme .....................................
  if(iVerbeux > 0)
  { printf("operating system   : %s %s\n", os_name, os_vers);
    printf("processor          : %s at %s Mhz with %.0f RAM\n", cpu, freq, mem);
    printf("number of loops    : %i\n", iCompteurBoucle);
    printf("running time       : %li\n", duration);
    printf("frames per seconde : %g \n", fps);
    //printf ( "Compilateur      : %s\n" , COMPILO );
  }
#endif
}

//------------------------------------------------------------------------------
// display error message
// input => _Message :  message 
//------------------------------------------------------------------------------
void afficheMessage(char *_Message)
{ 
  printf("%s\n", _Message);
}

//------------------------------------------------------------------------------
// display error message
// input => _Message1 :  message 1 
//       => _Message2 :  message 2 
//------------------------------------------------------------------------------
void afficheMessage(char *_Message1, char *_Message2)
{
  printf("%s %s\n", _Message1, _Message2);
}

//------------------------------------------------------------------------------
// display error message
// input => _pErreur1 : error message 
//       => _pErreur2 : title error
//------------------------------------------------------------------------------
void afficheErreur(char *_pErreur1, char *_pErreur2)
{
  printf("%s %s\n", _pErreur2, _pErreur1);
}

//------------------------------------------------------------------------------
// display error message
// input        => _pErreur1 : error message 
//              => _pErreur2 : title error
//              => _pErreur3 : error message
//------------------------------------------------------------------------------
void afficheErreur(char *_pErreur1, char *_pErreur2, char *_pErreur3)
{
  printf("%s %s %s\n", _pErreur2, _pErreur1, _pErreur3);
}

//------------------------------------------------------------------------------
// display error message
// input        => _pErreur1 : error message 
//              => _pErreur2 : title error
//              => _iErreur : error number
//------------------------------------------------------------------------------
void afficheErreur(char *_pErreur1, char *_pErreur2, int _iErreur)
{
  printf("%s %s error=%i\n", _pErreur2, _pErreur1, _iErreur);
}

//------------------------------------------------------------------------------
// sleep process
// input => i : time
//------------------------------------------------------------------------------
int synchro_processusPause(int _iTemps)
{
#ifdef SDL_TLK 
  if(_iTemps > (int)iFrame3)
    _iTemps = iFrame3;
  if(_iTemps > 0)
    SDL_Delay(_iTemps);
  return (_iTemps > 0 ? _iTemps : 0);
#else
  struct timeval temps;
  if(_iTemps > (int)iFrame3)
    _iTemps = iFrame3;
  if(_iTemps > 0)
  { temps.tv_usec = _iTemps % (unsigned long)1000000;
    temps.tv_sec = _iTemps / (unsigned long)1000000;
    //sleep for a time interval
    select(0, NULL, NULL, NULL, &temps);
  }
  return (_iTemps > 0 ? _iTemps : 0);
#endif
}

#ifdef SDL_TLK
int synchro_CalculDifference()
{
  int _iDifference;
  temps_actuel = SDL_GetTicks();
  _iDifference = temps_actuel - temps_sauve;
  temps_sauve = temps_actuel;
  return _iDifference;
}
#else
//------------------------------------------------------------------------------
// calcul la difference entre deux heure differentes
// sortie <= : _iDifference
//------------------------------------------------------------------------------
int synchro_CalculDifference()
{
  int _iDifference;
  gettimeofday(&temps_actuel, NULL);
  _iDifference = (1000000 * (temps_actuel.tv_sec - temps_sauve.tv_sec)) + (temps_actuel.tv_usec - temps_sauve.tv_usec);
  temps_sauve = temps_actuel;
  return _iDifference;
}

//------------------------------------------------------------------------------
// calcul la difference entre deux heure differentes
// sortie <= : _iDifference
//------------------------------------------------------------------------------
int synchro_CalculDifference2()
{
  int _iDifference;
  gettimeofday(&temps_actuel2, NULL);
  _iDifference = (1000000 * (temps_actuel2.tv_sec - temps_sauve2.tv_sec)) + (temps_actuel2.tv_usec - temps_sauve2.tv_usec);
  temps_sauve2 = temps_actuel2;
  return _iDifference;
}
#endif
