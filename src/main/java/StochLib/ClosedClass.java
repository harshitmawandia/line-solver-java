package StochLib;

import StochLib.JobClass;
import StochLib.JobClassType;
import StochLib.Network;
import StochLib.Station;

import java.io.Serializable;

public class ClosedClass extends JobClass implements Serializable {
    protected long population;
    protected Station refstat;
    protected int classIndex;
    protected Network model;
    public ClosedClass(Network model, String name, long njobs, Station refstat, int priority) {
        super(JobClassType.Open, name);
        model.addJobClass(this);
        this.population = njobs;
        this.model = model;
        this.refstat = refstat;
        this.classIndex = -1;
    }
    public ClosedClass(Network model, String name, long njobs, Station refstat) {
        this(model, name,njobs, refstat,0);
    }

    @Override
    public void printSummary() {
        System.out.format("Closed class: %s\n", this.getName());
    }

    @Override
    public double getNumberOfJobs() {
        return (double)population;
    }

    public Station getRefstat() {
        return this.refstat;
    }

    public long getPopulation() {
        return this.population;
    }

    @Override
    public int getJobClassIdx() {
        if (this.classIndex == -1) {
            this.classIndex = this.model.getJobClassIndex(this);
        }
        return this.classIndex;
    }
}
