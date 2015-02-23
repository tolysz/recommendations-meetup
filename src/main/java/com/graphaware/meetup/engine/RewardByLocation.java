package com.graphaware.meetup.engine;

import com.graphaware.reco.neo4j.post.RewardSomethingShared;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

/**
 * Created by m on 23/02/15.
 */
public class RewardByLocation extends RewardSomethingShared {

    @Override
    protected RelationshipType type() {
        return DynamicRelationshipType.withName("LOCATED_IN");
    }

    @Override
    protected Direction direction() {
        return Direction.OUTGOING;
    }

    @Override
    protected String scoreName() {
        return "RewardLocation";
    }

    @Override
    protected float scoreValue(Node node, Node node1, Node node2) {
        return 20;
    }
}
