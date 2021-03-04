import de.dep.Dependency;
import de.dep.impl.DEpendencyImpl2;
import de.dep.impl.DependencyImpl;

module Tag1_02MyDependency {
	
	requires transitive Tag1_03UnteresLevel;
	
	opens de.dep;
	
	exports de.dep;
	uses Dependency;
	provides Dependency with DependencyImpl, DEpendencyImpl2;
}