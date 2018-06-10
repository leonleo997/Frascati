INTEGRANTES: 	Ana María Arango Archibold
		Santiago Restrepo Prado
		Víctor Manuel Potes Valencia
==================================================================================================
REGLAS DE COMPILACIÓN										||
==================================================================================================
En esta carpeta incluimos 11 proyectos: 8 Sorters, 4 Sorters, 1 Sorter y PartialSort 1 - 8. Basta 
con que elija qué variante de distribución desea y bajar tantos PartialSorts requiera. 
El primer paso para ejecutar los proyectos consiste en alojarlos en las máquinas que desee y modificar 
el host en el archivo .composite ubicado en src/main/java/resources de cada proyecto. El siguiente 
paso puede omitirse debido a que los proyectos están debidamente compilados. Sin embargo, 
si desea hacer modificaciones en el código fuente el comando para re-compilar el proyecto es 
				frascati compile src <nombre Jar>
El orden para ejecutar los proyectos usando el comando
			frascati run <nombre composite> -libpath <nombre Jar Compilado>
es el siguiente:
1. Ejecutar todas las instancias de PartialSort
2. Ejecutar el Merge
3. Ejecutar Control
4. Ejecutar Cliente